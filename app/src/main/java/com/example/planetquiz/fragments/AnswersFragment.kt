package com.example.planetquiz.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.example.planetquiz.R
import com.example.planetquiz.databinding.FragmentAnswersBinding


class AnswersFragment : Fragment(), View.OnClickListener {
    private var _binding: FragmentAnswersBinding? = null
    private val binding get() = _binding!!
    private var questionId: Int = NO_QUESTION_SET
    private val headerText: TextView? get() = binding.headerText
    private val answerText: TextView? get() = binding.answerText

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentAnswersBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    companion object {
        private const val QUESTION_ID = "QUESTION_ID"
        private const val NO_QUESTION_SET = 0

        @JvmStatic
        fun newInstance(questionId: Int) = AnswersFragment().apply {
            arguments = Bundle().apply {
                putInt(QUESTION_ID, questionId)
            }
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val planets = listOf<View>(
            binding.earth,
            binding.jupiter,
            binding.mars,
            binding.mercury,
            binding.neptune,
            binding.saturn,
            binding.uranus,
            binding.venus
        )

        planets.forEach {
            it.setOnClickListener(this)
        }
        questionId = arguments?.getInt(QUESTION_ID) ?: NO_QUESTION_SET

        // Set Header Text
        when (questionId) {
            R.id.question_one_button -> {
                headerText?.text = getString(R.string.question_one_text)
            }

            R.id.question_two_button -> {
                headerText?.text = getString(R.string.question_two_text)
            }

            R.id.question_three_button -> {
                headerText?.text = getString(R.string.question_three_text)
            }
        }
    }


    override fun onClick(v: View?) {
        when (questionId) {
            R.id.question_one_button -> {
                if (v?.id == R.id.jupiter) {
                    answerText?.text =
                        getString(R.string.jupiter_answer, getString(R.string.correct))
                } else {
                    answerText?.text =
                        getString(R.string.jupiter_answer, getString(R.string.wrong))
                }
            }

            R.id.question_two_button -> {
                if (v?.id == R.id.saturn) {
                    answerText?.text =
                        getString(R.string.saturn_answer, getString(R.string.correct))
                } else {
                    answerText?.text =
                        getString(R.string.saturn_answer, getString(R.string.wrong))
                }
            }

            R.id.question_three_button -> {
                if (v?.id == R.id.uranus) {
                    answerText?.text =
                        getString(R.string.uranus_answer, getString(R.string.correct))
                } else {
                    answerText?.text =
                        getString(R.string.uranus_answer, getString(R.string.wrong))
                }
            }
        }
    }
}