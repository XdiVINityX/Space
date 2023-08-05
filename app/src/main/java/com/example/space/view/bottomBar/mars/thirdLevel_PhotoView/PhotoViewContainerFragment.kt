package com.example.space.view.bottomBar.mars.thirdLevel_PhotoView

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import coil.load
import com.example.space.databinding.FragmentPhotoViewContainerBinding
import com.example.space.utils.extensions.hideStatusBar
import com.example.space.utils.extensions.showStatusBar


class PhotoViewContainerFragment : Fragment() {
    private var _binding : FragmentPhotoViewContainerBinding? = null
    private val binding get() = _binding!!

    private lateinit var url : String


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentPhotoViewContainerBinding.inflate(inflater,container,false )
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        if (savedInstanceState != null){
            url = savedInstanceState.getString(BUNDLE_KEY)!!
        }
        url = arguments?.getString(BUNDLE_KEY) ?: "Пусто"

        binding.photoView.load(url)

        this.hideStatusBar()

    }

    companion object {
        @JvmStatic
        fun newInstance(bundle : Bundle) : PhotoViewContainerFragment {
           val fragment = PhotoViewContainerFragment()
            fragment.arguments = bundle
            return  fragment
        }
        const val BUNDLE_KEY = "key"
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putString(BUNDLE_KEY,url)
    }



    override fun onDestroyView() {
        super.onDestroyView()
        this.showStatusBar()
        _binding = null
    }
}