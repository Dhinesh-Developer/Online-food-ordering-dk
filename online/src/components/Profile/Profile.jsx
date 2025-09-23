import React, { useState } from 'react';
import ProfileNavigation from './ProfileNavigation';
import { IconButton } from '@mui/material';
import MenuIcon from '@mui/icons-material/Menu';
import Orders from './Orders';
import Address from './Address';
import Favourite from './Favourite';
import Events from './Events';
import UserProfile from './UserProfile';
import { Route, Routes } from 'react-router-dom';

const Profile = () => {
  const [openSideBar, setOpenSideBar] = useState(false);

  return (
    <div className="flex">
      {/* Sidebar for large screens */}
      <div className="lg:block hidden">
        <ProfileNavigation open={true} />
      </div>

      {/* Mobile Sidebar toggle */}
      <div className="lg:hidden">
        <IconButton onClick={() => setOpenSideBar(true)}>
          <MenuIcon style={{ color: 'white' }} />
        </IconButton>
        <ProfileNavigation 
          open={openSideBar} 
          handleClose={() => setOpenSideBar(false)} 
        />
      </div>

      {/* Main Content Area */}
      <div className="flex-1 p-5">
        <Routes>
          <Route index element={<UserProfile />} /> {/* default route */}
          <Route path="orders" element={<Orders />} />
          <Route path="address" element={<Address />} />
          <Route path="favourites" element={<Favourite />} />
          <Route path="events" element={<Events />} />
        </Routes>
      </div>
    </div>
  );
};

export default Profile;
