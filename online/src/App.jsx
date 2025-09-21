import React from 'react';
import Navbar from '../src/components/Navbar.jsx'
import { ThemeProvider } from '@emotion/react';
import { darkTheme } from './Theme/DarkTheme.jsx';
import { CssBaseline } from '@mui/material';
import Home from './components/Home/Home.jsx';
import RestaurantDetails from './components/Restaurant/RestaurantDetails.jsx';
function App() {
  return (
    <ThemeProvider theme={darkTheme}>
        <CssBaseline/>
          <Navbar/>
          {/* <Home/> */}
          <RestaurantDetails/>

    </ThemeProvider>

  );
}

export default App;
