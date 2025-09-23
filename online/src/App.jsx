import React from 'react';
import Navbar from '../src/components/Navbar.jsx'
import { ThemeProvider } from '@emotion/react';
import { darkTheme } from './Theme/DarkTheme.jsx';
import { CssBaseline } from '@mui/material';
import Home from './components/Home/Home.jsx';
import RestaurantDetails from './components/Restaurant/RestaurantDetails.jsx';
import Card from './components/Card/Card.jsx';
import Profile from './components/Profile/Profile.jsx';
import CustomRoute from './Routers/CustomRoute.jsx';
function App() {
  return (
    <ThemeProvider theme={darkTheme}>
        <CssBaseline/>
          {/* <Navbar/> */}
          {/* <Home/> */}
          {/* <RestaurantDetails/> */}
          {/* <Card/> */}
          {/* <Profile/> */}
          <CustomRoute/>

    </ThemeProvider>

  );
}

export default App;
