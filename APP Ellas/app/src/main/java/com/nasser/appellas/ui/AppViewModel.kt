package com.nasser.appellas.ui

import android.widget.Toast
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.nasser.appellas.R
import com.nasser.appellas.data.Blogs
import com.nasser.appellas.data.Contacts
import com.nasser.appellas.data.Users
import com.nasser.appellas.data.entity.Blog
import com.nasser.appellas.data.entity.TrustContacts
import com.nasser.appellas.data.entity.User
import com.nasser.appellas.network.AppApi
import com.nasser.appellas.repository.AppRepository
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class AppViewModel(private val appRepository: AppRepository): ViewModel() {

    private val _showCall = MutableLiveData<Boolean?>()
    val showCall: LiveData<Boolean?> = _showCall

    private val _showMessage = MutableLiveData<Boolean?>()
    val showMessage: LiveData<Boolean?> = _showMessage

    private val _showRegisterMessage = MutableLiveData<Boolean?>()
    val showRegisterMessage: LiveData<Boolean?> = _showRegisterMessage

    private val _showErrorMessage = MutableLiveData<Boolean?>()
    val showErrorMessage: LiveData<Boolean?> = _showErrorMessage

    private val _showMissingRegisterMessage = MutableLiveData<Boolean?>()
    val showMissingRegisterMessage: LiveData<Boolean?> = _showMissingRegisterMessage

    private val _showMissingBlogMessage = MutableLiveData<Boolean?>()
    val showMissingBlogMessage: LiveData<Boolean?> = _showMissingBlogMessage

    private val _showCreateBlogMessage = MutableLiveData<Boolean?>()
    val showCreateBlogMessage: LiveData<Boolean?> = _showCreateBlogMessage

    private val _showLoginMessage = MutableLiveData<Boolean?>()
    val showLoginMessage: LiveData<Boolean?> = _showLoginMessage

    private val _showErrorLoginMessage = MutableLiveData<Boolean?>()
    val showErrorLoginMessage: LiveData<Boolean?> = _showErrorLoginMessage

    private val _showMissingChangeMessage = MutableLiveData<Boolean?>()
    val showMissingChangeMessage: LiveData<Boolean?> = _showMissingChangeMessage

    private val _showChangeMessage = MutableLiveData<Boolean?>()
    val showChangeMessage: LiveData<Boolean?> = _showChangeMessage

    private val _showErrorChangeMessage = MutableLiveData<Boolean?>()
    val showErrorChangeMessage: LiveData<Boolean?> = _showErrorChangeMessage

    private val _showNoChangeMessage = MutableLiveData<Boolean?>()
    val showNoChangeMessage: LiveData<Boolean?> = _showNoChangeMessage

    private val _showMissingProfileMessage = MutableLiveData<Boolean?>()
    val showMissingProfileMessage: LiveData<Boolean?> = _showMissingProfileMessage

    private val _showDeleteMessage = MutableLiveData<Boolean?>()
    val showDeleteMessage: LiveData<Boolean?> = _showDeleteMessage

    private val _showErrorProfileMessage = MutableLiveData<Boolean?>()
    val showErrorProfileMessage: LiveData<Boolean?> = _showErrorProfileMessage

    private val _showMissingContactMessage = MutableLiveData<Boolean?>()
    val showMissingContactMessage: LiveData<Boolean?> = _showMissingContactMessage

    private val _showContactMessage = MutableLiveData<Boolean?>()
    val showContactMessage: LiveData<Boolean?> = _showContactMessage

    //Variables utilizadas para el login
    val userLoginInput = MutableLiveData("")
    val passwordLoginInput = MutableLiveData("")

    //Variables utilizadas para registrar usuarios
    val emailInput = MutableLiveData("")
    val userInput = MutableLiveData("")
    val passwordInput = MutableLiveData("")
    val confirmPassword = MutableLiveData("")

    //Variables utilizadas para cambiar contraseña
    val userChangeInput = MutableLiveData("")
    val passChangeInput = MutableLiveData("")
    val newPassInput = MutableLiveData("")
    val confirmNewInput = MutableLiveData("")

    //Varaibles utilizadas para añadir blog
    val tittleInput = MutableLiveData("")
    val subtittleInput = MutableLiveData("")
    val descriptionInput = MutableLiveData("")

    //Variables utilizadas para perfil
    val userProfileInput = MutableLiveData("")
    val passwordProfileInput = MutableLiveData("")
    val emailProfileInput = MutableLiveData("")

    //Variables utilizadas para crear contacto
    val contactNameInput = MutableLiveData("")
    val numberContactInput = MutableLiveData("")

    //Varaibles utilizadas para recyclerview
    val userList = appRepository.findAllUsers()
    val blogList = appRepository.findAllBlogs()

    private val _actual = MutableLiveData<Int>()
    val actual: LiveData<Int> get() = _actual
    private val formPages: List<Int> = listOf(
        R.id.loginFragment,
        R.id.registerFragment,
        R.id.passwordRecoveryFragment,
        R.id.pageHomeFragment,
        R.id.blogInformativeFragment,
        R.id.pageAdvisoryFragment,
        R.id.seccionJuridicaFragment,
        R.id.medicoFragment,
        R.id.psicologoFragment,
        R.id.mapaFragment,
        R.id.perfilUsuarioFragment,
        R.id.configurationFragment,
        R.id.trustedContactsFragment,
        R.id.adminFragment,
        R.id.adminAccountsFragment,
        R.id.adminMapFragment,
        R.id.createBlogFragment,
        R.id.createContactFragment,
        R.id.alertFragment,
        R.id.informationPageFragment
    )
    init {
        _actual.value = 0

    }

    fun getActual() = formPages[actual.value ?: 0]

    fun goLoginFragment() {
        _actual.apply {
            value = 0
        }
    }

    fun goRegisterFragment() {
        _actual.apply {
            value = 1
        }
    }
    fun goRecoveryFragment() {
        _actual.apply {
            value = 2
        }
    }
    fun goHomesFragment() {
        _actual.apply {
            value = 3
        }
    }



    fun goBlogFragment() {
        _actual.apply {
            value = 4
        }
    }

    fun goAdvisoryFragment() {
        _actual.apply {
            value = 5
        }
    }

    fun goLegalFragment() {
        _actual.apply {
            value = 6
        }
    }

    fun goMedicFragment() {
        _actual.apply {
            value = 7
        }
    }

    fun goPsychologistFragment() {
        _actual.apply {
            value = 8
        }
    }

    fun goMapFragment() {
        _actual.apply {
            value = 9
        }
    }

    fun goProfileFragment() {
        _actual.apply {
            value = 10
        }
    }

    fun goConfigurationFragment() {
        _actual.apply {
            value = 11
        }
    }

    fun goContactsFragment() {
        _actual.apply {
            value = 12
        }
    }

    fun goAdminHomeFragment() {
        _actual.apply {
            value = 13
        }
    }

    fun goAdminAccountsFragment() {
        _actual.apply {
            value = 14
        }
    }

    fun goAdminMapFragment() {
        _actual.apply {
            value = 15
        }
    }

    fun goCreateBlogFragment() {
        _actual.apply {
            value = 16
        }
    }

    fun goCreateContactFragment() {
        _actual.apply {
            value = 17
        }
    }

    fun goAlertFragment() {
        _actual.apply {
            value = 18
        }
    }

    fun goInfoPageFragment() {
        _actual.apply {
            value = 19
        }
    }

    fun searchUser(key: String): Users? {
        var user: Users? = null

        viewModelScope.launch {
            user = appRepository.searchUsers(key)
        }
        return user
    }
    //Ponemos el livedata en start o end para que no haya perdida de memoria
    fun startShowCall() {
        _showCall.value = true
    }

    fun endShowCall() {
        _showCall.value = null
    }

    fun startShowMessage() {
        _showMessage.value = true
    }

    fun endShowMessage() {
        _showMessage.value = null
    }

    private fun startShowRegisterMessage() {
        _showRegisterMessage.value = true
    }

    fun endShowRegisterMessage() {
        _showRegisterMessage.value = null
    }

    private fun startShowErrorMessage() {
        _showErrorMessage.value = true
    }

    fun endShowErrorMessage() {
        _showErrorMessage.value = null
    }

    private fun startShowMissingRegisterMessage() {
        _showMissingRegisterMessage.value = true
    }

    fun endShowMissingRegisterMessage() {
        _showMissingRegisterMessage.value = null
    }

    private fun startShowMissingBlogMessage() {
        _showMissingBlogMessage.value = true
    }

    fun endShowMissingBlogMessage() {
        _showMissingBlogMessage.value = null
    }

    private fun startShowCreateBlogMessage() {
        _showCreateBlogMessage.value = true
    }

    fun endShowCreateBlogMessage() {
        _showCreateBlogMessage.value = null
    }

    private fun startShowLoginMessage() {
        _showLoginMessage.value = true
    }

    fun endShowLoginMessage() {
        _showLoginMessage.value = null
    }

    private fun startShowErrorLoginMessage() {
        _showErrorLoginMessage.value = true
    }

    fun endShowErrorLoginMessage() {
        _showErrorLoginMessage.value = null
    }

    private fun startShowMissingchangeMessage() {
        _showMissingChangeMessage.value = true
    }

    fun endShowMissingChangeMessage() {
        _showMissingChangeMessage.value = null
    }

    private fun startShowChangeMessage() {
        _showChangeMessage.value = true
    }

    fun endShowChangeMessage() {
        _showChangeMessage.value = null
    }

    private fun startShowErrorChangeMessage() {
        _showErrorChangeMessage.value = true
    }

    fun endShowErrorChangeMessage() {
        _showErrorChangeMessage.value = null
    }

    private fun startShowNoChangeMessage() {
        _showNoChangeMessage.value = true
    }

    fun endShowNoChangeMessage() {
        _showNoChangeMessage.value = null
    }

    private fun startShowMissingProfileMessage() {
        _showMissingProfileMessage.value = true
    }

    fun endShowMissingProfileMessage() {
        _showMissingProfileMessage.value = null
    }

    private fun startShowDeleteMessage() {
        _showDeleteMessage.value = true
    }

    fun endShowDeleteMessage() {
        _showDeleteMessage.value = null
    }

    private fun startShowErrorProfileMessage() {
        _showErrorProfileMessage.value = true
    }

    fun endShowErrorProfileMessage() {
        _showErrorProfileMessage.value = null
    }

    private fun startShowMissingContactMessage() {
        _showMissingContactMessage.value = true
    }

    fun endShowMissingContactMessage() {
        _showMissingContactMessage.value = null
    }

    private fun startShowContactMessage() {
        _showContactMessage.value = true
    }

    fun endShowContactMessage() {
        _showContactMessage.value = null
    }

    fun login(){
        viewModelScope.launch {
            try {
                if(userLoginInput.value.isNullOrEmpty() || passwordLoginInput.value.isNullOrEmpty()){
                    startShowLoginMessage()
                }
                else{
                    val user = appRepository.searchUser(userLoginInput.value!!)
                    if(user.password == passwordLoginInput.value){
                        if(!user.type)
                            goHomesFragment()
                        else
                            goAdminHomeFragment()
                    }
                    else{
                        startShowErrorLoginMessage()
                    }
                }
            }catch (e: Exception){}
        }
    }

    fun registerUser() {
        viewModelScope.launch {
            try {
                if(userInput.value.isNullOrEmpty() ||
                    emailInput.value.isNullOrEmpty() ||
                    passwordInput.value.isNullOrEmpty() ||
                    confirmPassword.value.isNullOrEmpty()){
                    startShowMissingRegisterMessage()
                }
                else{
                    if(passwordInput.value == confirmPassword.value){
                        val newUser = User(userInput.value!!,
                            emailInput.value!!,
                            passwordInput.value!!,
                            confirmPassword.value!!,
                            false)
                        appRepository.insertOrUpdateUser(newUser)
                        AppApi.service.createUser(userInput.value!!,
                                                    passwordInput.value!!,
                                                    passwordInput.value!!,
                                                    confirmPassword.value!!)
                            .enqueue(object: Callback<Users>{
                                override fun onResponse(
                                    call: Call<Users>,
                                    response: Response<Users>
                                ) {
                                    startShowRegisterMessage()
                                }
                                override fun onFailure(call: Call<Users>, t: Throwable) {
                                    startShowMissingRegisterMessage()
                                }
                            })
                        userInput.value = ""
                        emailInput.value = ""
                        passwordInput.value = ""
                        confirmPassword.value = ""
                        goLoginFragment()
                        startShowRegisterMessage()
                    }
                    else{
                        startShowErrorMessage()
                    }
                }
            }
            catch (e: Exception){}
        }
    }

    fun changePassword() {
        viewModelScope.launch {
            try {
                if(userChangeInput.value.isNullOrEmpty() ||
                    passChangeInput.value.isNullOrEmpty() ||
                    newPassInput.value.isNullOrEmpty() ||
                    confirmNewInput.value.isNullOrEmpty()){
                    startShowMissingchangeMessage()
                }
                else{
                    val user = appRepository.searchUser(userChangeInput.value!!)
                    if(user.password == passChangeInput.value){
                        if(newPassInput.value == confirmNewInput.value){
                            val changeUser = User(user.username,
                                user.email,
                                newPassInput.value!!,
                                confirmNewInput.value!!,
                                user.type)
                            appRepository.insertOrUpdateUser(changeUser)
                            startShowChangeMessage()
                            goLoginFragment()
                        }
                        else{
                            startShowErrorChangeMessage()
                        }
                    }
                    else{
                        startShowNoChangeMessage()
                    }
                }
            }catch (e: Exception){}
        }
    }

    fun deleteAccount() {
        viewModelScope.launch {
            try {
                if(userProfileInput.value.isNullOrEmpty() ||
                    emailProfileInput.value.isNullOrEmpty() ||
                    passwordProfileInput.value.isNullOrEmpty()){
                    startShowMissingProfileMessage()
                }
                else{
                    val user = appRepository.searchUser(userProfileInput.value!!)
                    if(user.password == passwordProfileInput.value && user.email == emailProfileInput.value){
                        appRepository.deleteUser(user)
                        startShowDeleteMessage()
                        goLoginFragment()
                    }
                    else{
                        startShowErrorProfileMessage()
                    }
                }
            }catch (e: Exception){}
        }
    }

    fun createBlog() {
        viewModelScope.launch {
            try {
                if(tittleInput.value.isNullOrEmpty() ||
                    subtittleInput.value.isNullOrEmpty() ||
                    descriptionInput.value.isNullOrEmpty()){
                    startShowMissingBlogMessage()
                }
                else{
                    val newBlog = Blog(0,tittleInput.value!!,
                        subtittleInput.value!!,
                        descriptionInput.value!!,
                        "jnasser")
                    appRepository.insertOrUpdateBlog(newBlog)
                    AppApi.service.createBlog(tittleInput.value!!, subtittleInput.value!!, descriptionInput.value!!)
                        .enqueue(object: Callback<Blogs>{
                            override fun onResponse(
                                call: Call<Blogs>,
                                response: Response<Blogs>
                            ) {
                                startShowCreateBlogMessage()
                            }
                            override fun onFailure(call: Call<Blogs>, t: Throwable) {
                                startShowMissingBlogMessage()
                            }
                        })
                    goBlogFragment()
                    startShowCreateBlogMessage()
                }
            } catch (e: Exception){}
        }
    }

    fun createContact() {
        viewModelScope.launch {
            try {
                if(contactNameInput.value.isNullOrEmpty() || numberContactInput.value.isNullOrEmpty()){
                    startShowMissingContactMessage()
                }
                else{
                    val newContact = TrustContacts(0,contactNameInput.value!!,
                        numberContactInput.value!!.toInt(), "jnasser")
                    appRepository.insertOrUpdateContact(newContact)
                    AppApi.service.createContact(contactNameInput.value!!, numberContactInput.value!!.toInt())
                        .enqueue(object: Callback<Contacts>{
                            override fun onResponse(
                                call: Call<Contacts>,
                                response: Response<Contacts>
                            ) {
                                startShowCreateBlogMessage()
                            }
                            override fun onFailure(call: Call<Contacts>, t: Throwable) {
                                startShowMissingBlogMessage()
                            }
                        })
                    startShowContactMessage()
                }
            }catch (e: Exception){}
        }
    }

    fun deleteUser(user: User) {
        viewModelScope.launch {
            appRepository.deleteUser(user)
        }
    }
}