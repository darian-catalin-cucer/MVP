package cucerdariancatalin.mvp.ui.source

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.RecyclerView
import cucerdariancatalin.mvp.Injector
import cucerdariancatalin.mvp.R
import cucerdariancatalin.mvp.model.SourceResponse
import cucerdariancatalin.mvp.presenter.source.SourcePresenter
import cucerdariancatalin.mvp.ui.news.NewsActivity
import kotlinx.android.synthetic.main.activity_source.*
import javax.inject.Inject

class SourceActivity : AppCompatActivity(), SourceViewContract {

    @Inject
    lateinit var presenter: SourcePresenter

    private val adapter = SourceAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_source)

        setSupportActionBar(this.toolbar)

        Injector.obtain(this)!!.inject(this)

        setupView()

        presenter.setView(this)
        presenter.loadSource()
    }

    override fun onDestroy() {
        super.onDestroy()
        presenter.cancelLoadSource()
    }

    private fun setupView() {
        adapter.setClickListener(object : SourceAdapter.ItemClickListener {
            override fun onItemClickListener(item: SourceResponse.Sources) {
                val intent = Intent(applicationContext, NewsActivity::class.java)
                intent.putExtra("source", item.name)
                startActivity(intent)
            }

        })

        this.list.adapter = adapter
        this.list.layoutManager = GridLayoutManager(this, 2) as RecyclerView.LayoutManager?
    }

    override fun showSources(list: SourceResponse) {
        adapter.clearItems()
        adapter.setItems(list.sources)
    }
}
