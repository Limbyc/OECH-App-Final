package com.valance.oechappfinal.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.valance.oechappfinal.R
import com.valance.oechappfinal.databinding.StartFragmentBinding
import java.util.LinkedList

class StartFragment: Fragment() {
    private lateinit var binding: StartFragmentBinding
    private val queue1 = mutableListOf<String>()
    private val queue2 = mutableListOf<String>()
    private val imageQueue = LinkedList<Int>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = StartFragmentBinding.inflate(inflater, container, false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        queue1.add("Quick Delivery At Your \nDoorstep")
        queue1.add("Flexible Payment")
        queue1.add("Real-time Tracking")


        queue2.add("Enjoy quick pick-up and delivery to \nyour destination")
        queue2.add("Different modes of payment either \nbefore and after delivery without \nstress")
        queue2.add("Track your packages/items from the \ncomfort of your home till final destination")


        imageQueue.offer(R.drawable.in_no_time_pana_1)
        imageQueue.offer(R.drawable.rafiki)
        imageQueue.offer(R.drawable.rocket)

        if (imageQueue.isNotEmpty()) {
            imageQueue.peek()?.let { binding.appCompatImageView.setImageResource(it) }
        }
        if (queue1.isNotEmpty()) {
            binding.textOchared.text = queue1.first()
        }

        if (queue2.isNotEmpty()) {
            binding.textOcharedNear.text = queue2.first()
        }

        binding.buttonNext.setOnClickListener {
            if (queue1.isNotEmpty()) {
                queue1.removeAt(0)
                if (queue1.isNotEmpty()) {
                    binding.textOchared.text = queue1.first()
                }
            }

            if (queue2.isNotEmpty()) {
                queue2.removeAt(0)
                if (queue2.isNotEmpty()) {
                    binding.textOcharedNear.text = queue2.first()
                }
            }
            if (imageQueue.isNotEmpty()) {
                imageQueue.poll()
                if (imageQueue.isNotEmpty()) {
                    imageQueue.peek()
                        ?.let { it1 -> binding.appCompatImageView.setImageResource(it1) }
                }
            }
        }

        binding.buttonSkip.setOnClickListener{
            if (imageQueue.isNotEmpty()) {
                while (imageQueue.size > 1) {
                    imageQueue.poll()
                }
                imageQueue.peek()?.let { it1 -> binding.appCompatImageView.setImageResource(it1) }
                binding.buttonNext.visibility = View.GONE
                binding.buttonSkip.visibility = View.GONE
            }

        }
    }
}