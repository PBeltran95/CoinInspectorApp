package ar.com.thecoininspector.coininspector.ui.followed

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import ar.com.thecoininspector.coininspector.R
import ar.com.thecoininspector.coininspector.databinding.FragmentFollowedBinding

class FollowedFragment : Fragment(R.layout.fragment_followed) {

    private lateinit var binding:FragmentFollowedBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentFollowedBinding.bind(view)
    }

}