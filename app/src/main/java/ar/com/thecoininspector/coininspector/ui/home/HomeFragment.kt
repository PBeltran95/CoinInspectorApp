package ar.com.thecoininspector.coininspector.ui.home

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import ar.com.thecoininspector.coininspector.R
import ar.com.thecoininspector.coininspector.core.Response
import ar.com.thecoininspector.coininspector.data.models.Coin
import ar.com.thecoininspector.coininspector.databinding.FragmentHomeBinding
import ar.com.thecoininspector.coininspector.presentation.remote.CoinViewModel
import ar.com.thecoininspector.coininspector.ui.home.adapter.HomeAdapter
import ar.com.thecoininspector.coininspector.utils.toast
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class HomeFragment : Fragment(R.layout.fragment_home) {

    private lateinit var binding: FragmentHomeBinding
    private val viewModel by viewModels<CoinViewModel>()
    private val homeAdapter by lazy { HomeAdapter() }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentHomeBinding.bind(view)
        fetchCoins()
    }

    private fun fetchCoins() {
        viewModel.fetchCoins().observe(viewLifecycleOwner, Observer {
            when(it){
                is Response.Loading ->{
                    binding.progressBar.visibility = View.VISIBLE
                }
                is Response.Success -> {
                    binding.progressBar.visibility = View.GONE
                    val coins = it.metaData.data.coins
                    initAdapter(coins)
                }
                is Response.Failure -> {
                    toast(requireContext(), it.throwable.message)
                }
            }
        })
    }

    private fun initAdapter(coins: ArrayList<Coin>) {
        binding.rvHome.adapter = homeAdapter
        homeAdapter.setData(coins)
    }

}