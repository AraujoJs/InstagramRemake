package co.araujoarthur.instagramremake.common.model

import java.util.*
import kotlin.collections.HashSet

object Datasource {
    val userAuth = HashSet<UserAuth>()
    var sessionAuth: UserAuth? = null

    init {
        userAuth.add(UserAuth(UUID.randomUUID().toString(), "userA@gmail.com", "UserA", "12345678"))
        userAuth.add(UserAuth(UUID.randomUUID().toString(), "userB@gmail.com", "UserB", "87654321"))
    }

}