import React, { useEffect } from 'react';
import Navbar from './components/Navbar.jsx';
import { ThemeProvider } from '@emotion/react';
import { darkTheme } from './Theme/DarkTheme.jsx';
import { CssBaseline } from '@mui/material';
import Home from './components/Home/Home.jsx';
import RestaurantDetails from './components/Restaurant/RestaurantDetails.jsx';
import Card from './components/Card/Card.jsx';
import Profile from './components/Profile/Profile.jsx';
import CustomRoute from './Routers/CustomRoute.jsx';
import { useDispatch, useSelector } from 'react-redux';
import { getUser } from './components/State/Authentication/Action.jsx';


function App() {
  const dispatch = useDispatch()
  const jwt = localStorage.getItem("jwt")
  const { auth } = useSelector(store => store)

  useEffect(() => {
    if (auth.jwt || jwt) {
      dispatch(getUser(auth.jwt || jwt))
    }
  }, [auth.jwt, jwt, dispatch])

  return (
    <ThemeProvider theme={darkTheme}>
      <CssBaseline />
      <CustomRoute />
    </ThemeProvider>
  )
}

export default App
