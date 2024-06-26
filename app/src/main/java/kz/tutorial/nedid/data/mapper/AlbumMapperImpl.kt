package kz.tutorial.nedid.data.mapper

import kz.tutorial.nedid.data.entity.AlbumRemote
import kz.tutorial.nedid.data.entity.PhotoRemote
import kz.tutorial.nedid.domain.entity.Album
import kz.tutorial.nedid.domain.entity.User

class AlbumMapperImpl : AlbumMapper {
    override fun toDomain(albumRemote: AlbumRemote, user: User, previewPhoto: PhotoRemote): Album {
        return Album(
            userId = user.id,
            id = albumRemote.id,
            title = albumRemote.title,
            username = user.username,
            photoUrl = previewPhoto.thumbnailUrl,
        )
    }

    override fun toDomain(
        albums: List<AlbumRemote>,
        users: List<User>,
        photos: List<PhotoRemote>
    ): List<Album> {
        return albums.map { albumRemote ->
            val correspondingUser = users.find { it.id == albumRemote.userId }?: return emptyList()
            val correspondingPhoto = photos.first { it.albumId == albumRemote.id }

            toDomain(albumRemote, user = correspondingUser, previewPhoto = correspondingPhoto)
        }
    }
}