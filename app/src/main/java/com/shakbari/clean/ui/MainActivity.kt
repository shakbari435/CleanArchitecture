package com.shakbari.clean.ui

import android.os.Bundle
import androidx.activity.viewModels
import androidx.lifecycle.lifecycleScope
import com.shakbari.clean.R
import com.shakbari.clean.base.common.BaseActivity
import com.shakbari.clean.base.common.Status
import com.shakbari.clean.base.extension.*
import com.shakbari.clean.ui.adapter.MainAdapter
import com.shakbari.clean.data.model.User
import com.shakbari.clean.ui.viewmodel.MainViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

@AndroidEntryPoint
class MainActivity : BaseActivity() {


    private val mainViewModel: MainViewModel by viewModels()
    private val getUser by lazy { mainViewModel.getFlowUsers() }
    private val mainAdapter by lazy { MainAdapter() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        getData()

        recyclerView?.apply {
            verticalLinearLayoutManager(this@MainActivity)
            adapter = mainAdapter
            onLoadMore {
                mainAdapter.showLoading()
                getData()
            }
        }


        fab?.setOnClickListener {
            mainAdapter.addItem(User("", "09191723882", "", "Syd Hossein Akbari"), 1)
        }

        tryBtn?.setOnClickListener {
            getData()
        }

    }

    private fun getData() {
        lifecycleScope.launch {
            getUser.catch {
                showError()
            }.collect {
                when (it.status) {
                    Status.LOADING -> {
                        tryBtn.gone()
                        mainAdapter.showLoading()
                    }

                    Status.SUCCESS -> {
                        tryBtn.gone()
                        it.data?.let { users -> mainAdapter.addItemsRangeChange(ArrayList(users)) }
                    }

                    Status.ERROR -> {
                        showError()
                    }
                }
            }
        }
    }

    private fun showError() {
        mainAdapter.hideLoading()
        if (mainAdapter.getItems().isNullOrEmpty()) {
            tryBtn.visible()
            toast("please try again...")
        }
    }

}
