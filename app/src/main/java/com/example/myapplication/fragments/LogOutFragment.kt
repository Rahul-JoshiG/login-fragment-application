package com.example.myapplication.fragments

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.myapplication.R
import com.example.myapplication.activity.DashBoardActivity
import com.example.myapplication.activity.LogInActivity
import com.example.myapplication.databinding.FragmentLogOutBinding
import com.example.myapplication.interfaces.IFragmentInteraction
import com.example.myapplication.util.Constant
import com.example.myapplication.util.SessionManager

class LogOutFragment :
    Fragment(),
    View.OnClickListener {
    private lateinit var mBinding: FragmentLogOutBinding
    private lateinit var mFragmentInteraction: IFragmentInteraction
    private val mDashBoardFragment: DashBoardFragment by lazy { DashBoardFragment.newInstance() }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        Log.d(TAG, "onCreateView: ")
        mBinding = FragmentLogOutBinding.inflate(inflater, container, false)
        return mBinding.root
    }

    override fun onViewCreated(
        view: View,
        savedInstanceState: Bundle?,
    ) {
        super.onViewCreated(view, savedInstanceState)
        Log.d(TAG, "onViewCreated: ")
        setOnClickListener()
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        Log.d(TAG, "onAttach: ")
        mFragmentInteraction = context as DashBoardActivity
    }

    private fun setOnClickListener() {
        mBinding.logOutBtn.setOnClickListener(this)
        mBinding.previousFragmentBtn.setOnClickListener(this)
    }

    override fun onClick(v: View) {
        when (v.id) {
            R.id.log_out_btn -> {
                Log.d(TAG, "onClick: log out button pressed")
                navigateToLogInActivity()
            }

            R.id.previous_fragment_btn -> {
                Log.d(TAG, "onClick: for previous fragment button pressed")
                mFragmentInteraction.nextFragment(mDashBoardFragment)
            }
        }
    }

    private fun navigateToLogInActivity() {
        Log.d(TAG, "navigateToLogInActivity: ")
        val intent = Intent(requireContext(), LogInActivity::class.java)
        SessionManager.remove(Constant.Keys.IS_LOGGED_IN)
        startActivity(intent)
    }

    companion object {
        private const val TAG = "LogOutFragment"

        fun newInstance(): LogOutFragment = LogOutFragment()
    }
}
