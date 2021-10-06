package learn.idn.beginingproject

import android.app.Dialog
import android.content.DialogInterface
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity


class LoginActivity : AppCompatActivity() {

    private lateinit var dataEmail: Array<String>
    private lateinit var dataPassword: Array<String>
    private var progressBar: ProgressBar? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        val edtEmail : EditText = findViewById(R.id.edt_email)
        val edtPassword : EditText = findViewById(R.id.edt_password)
        val btnLogin : Button =  findViewById(R.id.btn_login)
        val btnRegister : Button = findViewById(R.id.btn_register)
        progressBar = findViewById(R.id.progress_bar)
        val btnForgetPass : TextView = findViewById(R.id.forget_password)
        val radioRemember : RadioButton = findViewById(R.id.rememberme)


//        val builder = AlertDialog.Builder(baseContext).create()
//        builder.setTitle("Harap isi")
//        builder.setMessage("Tentukan pilihan anda!")
//        builder.setIcon(R.drawable.ic_person)
//        builder.setPositiveButton("OK",
//            DialogInterface.OnClickListener { dialog, which -> })
//        builder.setCancelable(true)
//        builder.show()

        dataEmail = arrayOf("rizkia", "febri", "hardiansyah")
        dataPassword = arrayOf("1234", "4321", "1423")

        btnLogin.setOnClickListener {
            progressBar?.visibility = View.VISIBLE
            signIn(edtEmail.text.toString(), edtPassword.text.toString())
        }

        btnRegister.setOnClickListener {
            startActivity(Intent(this, RegisterActivity::class.java))
            finish()
        }

    }

    fun signIn(email: String, password: String)
    {
        for (i in dataEmail.indices){
            val takeDataEmail = dataEmail.get(i)
            val takeDataPass = dataPassword.get(i)
            if (takeDataEmail == email && takeDataPass == password){
                Toast.makeText(this, "LogedIn", Toast.LENGTH_SHORT).show()
                startActivity(Intent(this, HomeActivity::class.java))
                break
            }else{
                progressBar?.visibility = View.GONE
                Toast.makeText(this, "Akun Salah", Toast.LENGTH_SHORT).show()
            }
        }
    }

    override fun onStart() {
        super.onStart()
        Toast.makeText(this, "OnStart terpanggil", Toast.LENGTH_SHORT).show()
    }

    override fun onResume() {
        super.onResume()
        Toast.makeText(this, "OnResume terpanggil", Toast.LENGTH_SHORT).show()
    }

    override fun onRestart() {
        super.onRestart()
        Toast.makeText(this, "OnRestart terpanggil", Toast.LENGTH_SHORT).show()
    }

    override fun onPause() {
        super.onPause()
        Toast.makeText(this, "OnPause terpanggil", Toast.LENGTH_SHORT).show()
    }

    override fun onStop() {
        super.onStop()
        Toast.makeText(this, "OnStop terpanggil", Toast.LENGTH_SHORT).show()
    }

    override fun onDestroy() {
        super.onDestroy()
        Toast.makeText(this, "OnDestroy terpanggil", Toast.LENGTH_SHORT).show()
    }



}