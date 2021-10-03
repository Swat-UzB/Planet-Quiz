package com.example.planetquiz

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.planetquiz.databinding.ActivityMainBinding
import com.example.planetquiz.fragments.AnswersFragment
import com.example.planetquiz.fragments.QuestionsFragment

class MainActivity : AppCompatActivity(), AnswersListener {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        if (savedInstanceState == null) {
            binding.fragmentContainer?.let { frameLayout ->
                val questionsFragment = QuestionsFragment()
                supportFragmentManager.beginTransaction()
                    .add(frameLayout.id, questionsFragment)
                    .commit()
            }
        }
    }

    override fun onSelected(questionId: Int) {
        binding.fragmentContainer?.let { frameLayout ->
            val answersFragment = AnswersFragment.newInstance(questionId)

            supportFragmentManager.beginTransaction()
                .replace(frameLayout.id, answersFragment)
                .addToBackStack(null)
                .commit()
        }
    }
}