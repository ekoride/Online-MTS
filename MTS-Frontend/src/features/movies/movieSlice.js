import { createSlice, createAsyncThunk } from "@reduxjs/toolkit"

export const getMovies = createAsyncThunk(
    'movies/getMovies',
    async ( thunkAPI ) => {
        try{
            const response = await fetch(
                "http://localhost:8080/getAllMovies",
                {
                    method: 'GET',
                    headers: {
                        Accept: 'application/json',
                        'Content-Type': 'application/json'
                    }
                }
            );
            let data = await response.json();

            if(response.status === 200){
                return data;
            }else{
                console.log('data', data);
                return thunkAPI.rejectWithValue(data);
            }
        }catch(e){
            console.log('Error', e.response.data);
            return thunkAPI.rejectWithValue(e.response.data);
        }
    }
)

export const movieSlice = createSlice({
    name: "movies",
    initialState:{
        movieArray: [],
        isFetching: false,
        isSuccess: false,
        isError: false,
        errorMessage: "",
    },
    reducers: {
        clearState: (state) => {
            state.isError = false;
            state.isSuccess = false;
            state.isFetching = false;
            
            return state;
        },  
    },
    extraReducers: {
        // Extra reducer comes here
        [getMovies.fulfilled]: (state, {payload}) =>{
            state.isFetching = false;
            state.isSuccess = true;
            state.movieArray = payload;
            return state;
        },
        [getMovies.pending]: (state) => {
            state.isFetching = true;
        },
        [getMovies.rejected]: (state) => {
            state.isFetching = false;
            state.isError = true;
            state.errorMessage = "Cannot get the movies";
        }
    }
})

export const { clearState } = movieSlice.actions;

export const movieSelector = (state) => state.movies;