package com.vn.iambulance.testingappforprecoding

import android.annotation.SuppressLint
import android.app.PendingIntent
import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.view.View
import androidx.annotation.RequiresApi
import androidx.core.app.*
import androidx.fragment.app.FragmentActivity
import com.vn.iambulance.testingappforprecoding.FragmentAdapter.Companion.i
import com.vn.iambulance.testingappforprecoding.databinding.FragmentBinding

class MainActivity : FragmentActivity() {

    private lateinit var bindingFragment: FragmentBinding
    lateinit var activity: MainActivity
    lateinit var adapter: FragmentAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bindingFragment = FragmentBinding.inflate(layoutInflater)
        activity = this
        setContentView(bindingFragment.root)
        adapter = FragmentAdapter(this)
        bindingFragment.pager.adapter = adapter
    }

    override fun onNewIntent(intent: Intent?) {
        super.onNewIntent(intent)
        setIntent(intent)
    }

    @SuppressLint("NotifyDataSetChanged")
    @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
    fun plus(view: View) {
        i++
        adapter.createFragment(i)
        adapter.notifyDataSetChanged()
    }

    fun minus(view: View) {
        with(NotificationManagerCompat.from(this))
        { cancel(adapter.getItemId(bindingFragment.pager.currentItem + 1).toInt()) }
    }

    @RequiresApi(Build.VERSION_CODES.M)
    fun createNotification(view: View) {
        val intent = Intent(this, FragmentActivity::class.java)
        intent.apply {
            flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
        }
        val pendingIntent = PendingIntent.getActivity(this, 0, intent, 0)
        val builder = NotificationCompat.Builder(
            application.baseContext,
            CHANNEL_ID1
        )
            .setSmallIcon(R.drawable.ic_launcher_foreground)
            .setContentTitle("Notification ")
            .setContentText("Notification " +
                    "${adapter.getItemId(bindingFragment.pager.currentItem + 1)}")
            .setAutoCancel(true)
            .setPriority(NotificationCompat.PRIORITY_HIGH)
            .setCategory(NotificationCompat.CATEGORY_MESSAGE)
            .setContentIntent(pendingIntent)

        with(NotificationManagerCompat.from(this)) {
            notify(
                adapter.getItemId(bindingFragment.pager.currentItem + 1).toInt(),
                builder.build()
            )
        }
    }
}