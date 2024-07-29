package com.example.myapplication.fragments

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.myapplication.activity.DashBoardActivity
import com.example.myapplication.databinding.FragmentDashBoardBinding
import com.example.myapplication.interfaces.IFragmentInteraction
import com.example.myapplication.util.Constant
import com.example.myapplication.util.SessionManager

class DashBoardFragment :
    Fragment(),
    View.OnClickListener {
    private lateinit var mBinding: FragmentDashBoardBinding
    private lateinit var mFragmentInteraction: IFragmentInteraction
    private val mLogOutFragment: LogOutFragment by lazy { LogOutFragment.newInstance() }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        Log.d(TAG, "onCreateView: create view of dashboard fragment")
        mBinding = FragmentDashBoardBinding.inflate(inflater, container, false)
        receiveAndSetData()
        return mBinding.root
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        mFragmentInteraction = context as DashBoardActivity
    }

    override fun onViewCreated(
        view: View,
        savedInstanceState: Bundle?,
    ) {
        super.onViewCreated(view, savedInstanceState)
        Log.d(TAG, "onViewCreated: dashboard fragment created successfully")
        setOnClickListener()
    }

    private fun receiveAndSetData() {
        var email = arguments?.getString(Constant.Keys.EMAIL_KEY)
        if (email != null) {
            SessionManager.putString(Constant.Keys.EMAIL_KEY_IN_FRAGMENT, email)
        } else {
            email = SessionManager.getString(Constant.Keys.EMAIL_KEY_IN_FRAGMENT)
        }
        Log.d(TAG, "receiveData: email = $email")
        mBinding.emailTextView.text = email
    }

    private fun setOnClickListener() {
        mBinding.logOutNextBtn.setOnClickListener(this)
    }

    override fun onClick(v: View) {
        navigateToLogOutFragment()
    }

    private fun navigateToLogOutFragment() {
        Log.d(TAG, "navigateToLogOutFragment: ")
        mFragmentInteraction.nextFragment(mLogOutFragment)
    }

    companion object {
        private const val TAG = "DashBoardFragment"

        fun newInstance(): DashBoardFragment = DashBoardFragment()
    }
}
