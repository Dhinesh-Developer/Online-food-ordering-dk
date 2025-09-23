import React from 'react'
import Navbar from '../components/Navbar'
import { Route, Routes } from 'react-router-dom'
import Home from '../components/Home/Home'
import RestaurantCard from '../components/Restaurant/RestaurantDetails'
import Card from '../components/Card/Card'
import Profile from '../components/Profile/Profile'
import Auth from '../components/Auth/Auth'


const CustomRoute = () => {
  return (
    <div>
        <Navbar/>
        <Routes>
            <Route path='/' element={<Home/>}/>
            <Route path='/account/:register' element={<Home/>}/>
            <Route path='/restaurant/:city/:title/:id' element={<RestaurantCard/>}/>
            <Route path='/cart' element={<Card/>}/>
            <Route path='/my-profile/*' element={<Profile/>}/>

        </Routes>
        <Auth/>
    </div>
  )
}

export default CustomRoute