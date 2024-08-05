package jp.co.torihada.usecases

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonProperty

@JsonIgnoreProperties(ignoreUnknown = true)
data class Message(
    val type: String,
    val subtype: String? = null,
    val team: String? = null,
    val channel: String? = null,
    val user: String? = null,
    val username: String? = null,
    val text: String? = null,
    val blocks: List<Block>? = null,
    val attachments: List<Attachment>? = null,
    val ts: String,
    val threadTs: String? = null,
    val intro: Boolean? = null,
    val starred: Boolean? = null,
    val wibblr: Boolean? = null,
    val pinnedTo: List<String>? = null,
    val reactions: List<Reaction>? = null,
    val appId: String? = null,
    val botId: String? = null,
    val botLink: String? = null,
    val displayAsBot: Boolean? = null,
    val botProfile: BotProfile? = null,
    val icons: Icons? = null,
    val file: File? = null,
    val files: List<File>? = null,
    val upload: Boolean? = null,
    val parentUserId: String? = null,
    val inviter: String? = null,
    val clientMsgId: String? = null,
    val comment: String? = null,
    val topic: String? = null,
    val purpose: String? = null,
    val edited: Edited? = null,
    val unfurlLinks: Boolean? = null,
    val unfurlMedia: Boolean? = null,
    val threadBroadcast: Boolean? = null,
    val locked: Boolean? = null,
    val replies: List<Reply>? = null,
    val replyCount: Int? = null,
    val replyUsers: List<String>? = null,
    val replyUsersCount: Int? = null,
    val latestReply: String? = null,
    val subscribed: Boolean? = null,
    val xFiles: List<String>? = null,
    val hidden: Boolean? = null,
    val lastRead: String? = null,
    val root: Root? = null,
    val itemType: String? = null,
    val item: Item? = null,
    val metadata: Metadata? = null,
    val room: Room? = null,
    val noNotifications: Boolean? = null
)

@JsonIgnoreProperties(ignoreUnknown = true)
data class Block(
    val type: String,
    val block_id: String,
    val elements: List<Element>
)

@JsonIgnoreProperties(ignoreUnknown = true)
data class Element(
    val type: String,
    val text: String? = null,
    val url: String? = null,
    val channel_id: String? = null,
    val range: String? = null,
    val name: String? = null,
    val unicode: String? = null
)

@JsonIgnoreProperties(ignoreUnknown = true)
data class Attachment(
    val id: Int,
    val fallback: String,
    val color: String,
    val pretext: String,
    val author_name: String,
    val author_link: String,
    val author_icon: String,
    val title: String,
    val title_link: String,
    val text: String,
    val fields: List<Field>,
    val image_url: String,
    val thumb_url: String,
    val footer: String,
    val footer_icon: String,
    val ts: Long
)

@JsonIgnoreProperties(ignoreUnknown = true)
data class Field(
    val title: String,
    val value: String,
    val short: Boolean
)

@JsonIgnoreProperties(ignoreUnknown = true)
data class Reaction(
    val name: String,
    val count: Int,
    val users: List<String>
)

@JsonIgnoreProperties(ignoreUnknown = true)
data class BotProfile(
    val id: String,
    val app_id: String,
    val name: String,
    val icons: Icons,
    val deleted: Boolean,
    val updated: Long,
    val team_id: String
)

@JsonIgnoreProperties(ignoreUnknown = true)
data class Icons(
    val image_36: String,
    val image_48: String,
    val image_72: String
)

@JsonIgnoreProperties(ignoreUnknown = true)
data class File(
    val id: String,
    val created: Long,
    val timestamp: Long,
    val name: String,
    val title: String,
    val mimetype: String,
    val filetype: String,
    val pretty_type: String,
    val user: String,
    val mode: String,
    val editable: Boolean,
    val is_external: Boolean,
    val external_type: String,
    val size: Int,
    val url_private: String,
    val url_private_download: String,
    val thumb_64: String,
    val thumb_80: String,
    val thumb_160: String,
    val thumb_360: String,
    val thumb_360_w: Int,
    val thumb_360_h: Int,
    val thumb_480: String,
    val thumb_720: String,
    val thumb_960: String,
    val thumb_1024: String,
    val original_w: Int,
    val original_h: Int,
    val permalink: String,
    val permalink_public: String,
    val edit_link: String,
    val preview: String,
    val preview_highlight: String,
    val lines: Int,
    val lines_more: Int,
    val is_public: Boolean,
    val public_url_shared: Boolean,
    val display_as_bot: Boolean,
    val channels: List<String>,
    val groups: List<String>,
    val ims: List<String>,
    val comments_count: Int
)

@JsonIgnoreProperties(ignoreUnknown = true)
data class Edited(
    val user: String,
    val ts: String
)

@JsonIgnoreProperties(ignoreUnknown = true)
data class Reply(
    val user: String,
    val ts: String
)

@JsonIgnoreProperties(ignoreUnknown = true)
data class Root(
    val type: String,
    val subtype: String,
    val team: String,
    val channel: String,
    val user: String,
    val text: String,
    val ts: String
)

@JsonIgnoreProperties(ignoreUnknown = true)
data class Item(
    val type: String,
    val channel: String,
    val ts: String
)

@JsonIgnoreProperties(ignoreUnknown = true)
data class Metadata(
    val event_type: String,
    val event_payload: Map<String, Any>
)

@JsonIgnoreProperties(ignoreUnknown = true)
data class Room(
    val id: String,
    val name: String,
    val team_id: String
)
