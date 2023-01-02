package co.araujoarthur.instagramremake.common.model

import java.util.*
import kotlin.collections.HashSet

object Datasource {
    val userAuth = HashSet<UserAuth>()
    var sessionAuth: UserAuth? = null

    init {
        userAuth.add(UserAuth(UUID.randomUUID().toString(), "userA@gmail.com", "12345678"))
        userAuth.add(UserAuth(UUID.randomUUID().toString(), "userB@gmail.com", "87654321"))
    }

}