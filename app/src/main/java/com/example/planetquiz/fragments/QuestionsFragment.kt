package com.example.planetquiz.fragments

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.planetquiz.AnswersListener
import com.example.planetquiz.databinding.FragmentQuestionsBinding


class QuestionsFragment : Fragment(), View.OnClickListener {
    private lateinit var answersListener: AnswersListener
    private var _binding: FragmentQuestionsBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentQuestionsBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context is AnswersListener) {
            answersListener = context
        } else {
            throw RuntimeException("Must implement AnswersListener")
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val planets = listOf<View>(
            binding.questionOneButton,
            binding.questionTwoButton,
            binding.questionThreeButton
        )
        planets.forEach {
            it.setOnClickListener(this)
        }
    }

    override fun onClick(p0: View?) {
        p0?.let { question ->
            answersListener.onSelected(question.id)
        }
    }
}