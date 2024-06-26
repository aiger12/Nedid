package kz.tutorial.nedid.di

import kz.tutorial.nedid.presentation.post_details.PostDetailsViewModel
import kz.tutorial.nedid.presentation.posts.PostsViewModel
import kz.tutorial.nedid.presentation.show_all_comments.ShowAllViewModel
import kz.tutorial.nedid.presentation.users.UsersViewModel
import kz.tutorial.nedid.presentation.users.user_details.UserViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module


val viewModelModule = module {
    viewModel {
        PostsViewModel(get())
    }
    viewModel { (postId: Int) ->
        PostDetailsViewModel(
            getPostPreviewCommentsUseCase = get(),
            getPostUseCase = get(),
            getUserUseCase = get(),
            postId = postId
        )
    }
    //is it ok that I created viewModel for showAll here?
    viewModel {(postId: Int) ->
        ShowAllViewModel(
            getAllCommentsUseCase = get(),
            postId = postId
        )
    }
    viewModel {
        UsersViewModel(get())
    }

    viewModel{(userId: Int)->
        UserViewModel(get(),userId)
    }
}