package ar.com.thecoininspector.coininspector.ui.news

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import ar.com.thecoininspector.coininspector.R
import ar.com.thecoininspector.coininspector.core.Response
import ar.com.thecoininspector.coininspector.data.models.Result
import ar.com.thecoininspector.coininspector.databinding.FragmentNewsBinding
import ar.com.thecoininspector.coininspector.presentation.remote.CoinViewModel
import ar.com.thecoininspector.coininspector.utils.toast
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class NewsFragment : Fragment(R.layout.fragment_news) {

    private lateinit var binding: FragmentNewsBinding
    private val viewModel by viewModels<CoinViewModel>()
    private val newsAdapter by lazy { NewsAdapter() }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentNewsBinding.bind(view)
        fetchNews()
    }

    private fun fetchNews() {
        viewModel.fetchNews().observe(viewLifecycleOwner, Observer {
            when(it){
                is Response.Loading ->{

                }
                is Response.Success ->{
                    initRecyclerView(it.metaData.results)
                }
                is Response.Failure ->{
                    toast(requireContext(), it.throwable.message, true)
                }
            }
        })
    }

    private fun initRecyclerView(results: MutableList<Result>) {
        binding.rvNews.adapter = newsAdapter
        newsAdapter.setData(results)
    }

}