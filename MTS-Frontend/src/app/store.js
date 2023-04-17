import { configureStore } from "@reduxjs/toolkit"
import { userSlice } from "../features/user/userSlice"
import { movieSlice } from "../features/movies/movieSlice"
export default configureStore({
  reducer: {
    user: userSlice.reducer,
    movies: movieSlice.reducer,
  },
})