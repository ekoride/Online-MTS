import { createSlice, createAsyncThunk } from "@reduxjs/toolkit"

export const signupUser = createAsyncThunk(
    'users/signupUser',
    async ({ name, email, password, mobile, dob, address }, thunkAPI) => {
        try{
            const response = await fetch(
                'http://localhost:8080/userSignUp',
                {
                    method: 'POST',
                    headers:{
                        Accept: 'application/json',
                        'Content-Type': 'application/json'
                    },
                    body: JSON.stringify({
                        userName: name,
                        user_password: password,
                        userEmailId: email,
                        userAddress: address,
                        userPhone: mobile,
                        userDOB: dob
                    }),
                }
            );
            let data = await response.json();
            
            if(response.status === 201){
                localStorage.setItem('token','temptoken');
                return { ...data, userName: name, email: email}
            }else{
                console.log('data',data)
                return thunkAPI.rejectWithValue(data);
            }

        }catch(e){
            console.log('Error', e.response.data)
            return thunkAPI.rejectWithValue(e.response.data)
        }
    }
)

export const loginUser = createAsyncThunk(
    "users/login",
    async({email, password}, thunkAPI) => {
        try{
            // post request for login
            const response = await fetch(
                'http://localhost:8080/userLogin',
                {
                    method: 'POST',
                    headers:{
                        'Content-Type': 'application/json'
                    },
                    body: JSON.stringify({
                        email: email,
                        password: password
                    }),
                }
            )
            let data = await response.json();
            console.log('data', data);
            if(response.status === 200){
                // localStorage.setItem('token', 'temptoken')
                return data
            }else{
                return thunkAPI.rejectWithValue(data);
            }
        }catch(e){
            console.log('Error', e.response.data);
            return thunkAPI.rejectWithValue(e.response.data)
        }
    }
)

// we will modify this fetch user by token later
export const fetchUserBytoken = createAsyncThunk(
    'users/fetchUserByToken',
    async ({ token }, thunkAPI) => {
      try {
        const response = await fetch(
          'https://mock-user-auth-server.herokuapp.com/api/v1/users',
          {
            method: 'GET',
            headers: {
              Accept: 'application/json',
              Authorization: token,
              'Content-Type': 'application/json',
            },
          }
        );
        let data = await response.json();
        console.log('data', data, response.status);
  
        if (response.status === 200) {
          return { ...data };
        } else {
          return thunkAPI.rejectWithValue(data);
        }
      } catch (e) {
        console.log('Error', e.response.data);
        return thunkAPI.rejectWithValue(e.response.data);
      }
    }
  );

export const userSlice = createSlice({
  name: "user",
  initialState: {
    email: "",
    password: "",
    isFetching: false,
    isSuccess: false,
    isError: false,
    errorMessage: "",
    isLoggedIn: "",
    user_name: ""
  },
  reducers: {
    // Reducer comes here
    clearState: (state) => {
        state.isError = false;
        state.isSuccess = false;
        state.isFetching = false;
        
        return state;
    },
    // add logged in attribute and logged out reducer as well
    setLoggedIn: (state) => {
        state.isLoggedIn = true;
    },
    setLoggedOut: (state) => {
        state.isLoggedIn = false;
    }
  },
  extraReducers: {
    // Extra reducer comes here
    [signupUser.fulfilled]: (state, {payload}) =>{
        console.log('payload',payload);
        state.isFetching = false;
        state.isSuccess = true;
        state.email = payload.userEmailId;
        state.password = payload.user_password;
        state.user_name = payload.userName;
        return state;
    },
    [signupUser.pending]: (state) => {
        state.isFetching = true;
    },
    [signupUser.rejected]: (state, { payload }) => {
        state.isFetching = false;
        state.isError = true;
        state.errorMessage = "Please check your credentials and re-enter";
    },
    [loginUser.fulfilled]: (state, {payload}) =>{
        state.email = payload.userEmailId;
        state.password = payload.user_password;
        state.isFetching = false;
        state.isSuccess = true;
        state.user_name = payload.userName;
        return state;
    },
    [loginUser.rejected]: (state, {payload}) => {
        console.log('payload', payload);
        state.isFetching = false;
        state.isError = true;
        state.errorMessage = "Invalid email/password";
    },
    [loginUser.pending]: (state) => {
        state.isFetching = true;
    }
  },
})



export const { clearState, setLoggedIn, setLoggedOut } = userSlice.actions;

export const userSelector = (state) => state.user;