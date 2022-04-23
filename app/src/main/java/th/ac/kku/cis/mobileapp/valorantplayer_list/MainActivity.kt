package th.ac.kku.cis.mobileapp.valorantplayer_list

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import com.google.firebase.auth.FirebaseAuth
import th.ac.kku.cis.mobileapp.valorantplayer_list.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var userArraylist : ArrayList<User>

        override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
            super.onCreate(savedInstanceState, persistentState)
            binding = ActivityMainBinding.inflate(layoutInflater)
            setContentView(binding.root)

            val imageId = intArrayOf(

                R.drawable.fin,R.drawable.fuse,R.drawable.jay,R.drawable.ohm,R.drawable.smart,R.drawable.firo,R.drawable.tae,R.drawable.chol,

            )

            val name = arrayOf(

                "fin",
                "fuse",
                "jay",
                "ohm",
                "smart",
                "firo",
                "tae",
                "chol",

                )

            val lastMessage = arrayOf(
                "top1","top2","top3","top4","top5","top6","top7","top8",
            )

            val lastmsgTime = arrayOf(

                "Radaint","Immortal","Immortal","Platinum","Diamond","Gold","Silver","Bronze","Iron",
            )

            val phoneNo = arrayOf(

                "099-169-6508","099-412-5123","087-453-1543","084-346-1251","095-512-1235","082-016-1255","062-815-8123","093-125-6123","099-169-6558",
            )

            val country = arrayOf(

               "Bangkok", "Khonkhean", "loei", "Nongkhai", "Udonthani", "Cholburi", "Bangkok", "Kalasin", "Bangkok",

            )

            userArraylist = ArrayList()

            for( i in name.indices){

                val user = User(name[i],lastMessage[i],lastmsgTime[i],phoneNo[i],country[i],imageId[i])
                userArraylist.add(user)


            }

            binding.listview.isClickable = true
            binding.listview.adapter = MyAdapter(this,userArraylist)
            binding.listview.setOnItemClickListener { parent, view, position, id ->

                val name = name[position]
                val phoneNo = phoneNo[position]
                val country = country[position]
                val imageId = imageId[position]

                val i =  Intent(this,UserActivity::class.java)
                i.putExtra("name",name)
                i.putExtra("phone",phoneNo)
                i.putExtra("country",country)
                i.putExtra("imageId",imageId)
                startActivity(i)


            }

            FirebaseAuth.getInstance().signOut();

        }
    }
