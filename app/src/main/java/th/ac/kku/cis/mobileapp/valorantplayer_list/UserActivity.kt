package th.ac.kku.cis.mobileapp.valorantplayer_list

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import th.ac.kku.cis.mobileapp.valorantplayer_list.databinding.ActivityUserBinding

class UserActivity : AppCompatActivity(){

      private lateinit var binding : ActivityUserBinding

      override fun onCreate(savedInstanceState: Bundle?) {
          super.onCreate(savedInstanceState)
          binding = ActivityUserBinding.inflate(layoutInflater)
          setContentView(binding.root)

          val name = intent.getStringExtra("name")
          val phone = intent.getStringExtra("phone")
          val country = intent.getStringExtra("country")
          val imageId = intent.getIntExtra("imageId",R.drawable.facebook_avatar)


      }

}