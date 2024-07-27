package com.example.myapplication.activity

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.example.myapplication.R
import com.example.myapplication.databinding.ActivityDashboardBinding
import com.example.myapplication.fragments.DashBoardFragment
import com.example.myapplication.interfaces.IFragmentInteraction
import com.example.myapplication.util.Constant

class DashBoardActivity :
    AppCompatActivity(),
    IFragmentInteraction {
    private lateinit var mBinding: ActivityDashboardBinding
    private val mFragmentManager = supportFragmentManager
    private lateinit var mCurrentVisibleFragment: Fragment
    private val mDashBoardFragment: DashBoardFragment by lazy { DashBoardFragment.newInstance() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_dashboard)
        setContentView(mBinding.root)

        retrieveAndSendData()
        openFragment(mDashBoardFragment)
    }

    private fun retrieveAndSendData() {
        val bundle = Bundle()
        val email = intent.extras?.getString(Constant.Keys.EMAIL_KEY)
        bundle.putString(Constant.Keys.EMAIL_KEY, email)
        mDashBoardFragment.arguments = bundle
        Log.d(TAG, "retrieveData: email = $email")
    }

    private fun openFragment(fragment: Fragment) {
        Log.d(TAG, "openFragment: opening fragment $fragment")
        if (::mCurrentVisibleFragment.isInitialized) {
            hideFragment(mCurrentVisibleFragment)
        }
        addShowFragment(fragment)
    }

    private fun addShowFragment(fragment: Fragment) {
        Log.d(TAG, "addShowFragment: add and show the fragment $fragment")
        val ft = mFragmentManager.beginTransaction()
        if (!fragment.isAdded) {
            mCurrentVisibleFragment = fragment
            ft.add(R.id.fragment_view_container, fragment)
            ft.commitAllowingStateLoss()
            return
        }
        showFragment(fragment)
    }

    private fun showFragment(fragment: Fragment) {
        mCurrentVisibleFragment = fragment
        val ft = mFragmentManager.beginTransaction()
        ft.show(fragment)
        ft.commit()
    }

    private fun hideFragment(fragment: Fragment) {
        Log.d(TAG, "hideFragment: hide the fragment $fragment")
        val ft = mFragmentManager.beginTransaction()
        ft.hide(fragment)
        ft.commit()
    }

    override fun nextFragment(fragment: Fragment) {
        openFragment(fragment)
    }

    companion object {
        private const val TAG = "DashBoardActivity"
    }
}
