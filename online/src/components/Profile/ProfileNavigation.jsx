import React, { useState } from 'react';
import ShoppingBagIcon from '@mui/icons-material/ShoppingBag';
import FavoriteIcon from '@mui/icons-material/Favorite';
import HomeIcon from '@mui/icons-material/Home';
import AccountBalanceWalletIcon from '@mui/icons-material/AccountBalanceWallet';
import NotificationsActiveIcon from '@mui/icons-material/NotificationsActive';
import EventIcon from '@mui/icons-material/Event';
import LogoutIcon from '@mui/icons-material/Logout';
import { Divider, Drawer, useMediaQuery } from '@mui/material';
import { useNavigate } from 'react-router-dom';


const menu = [
  { title: "Orders", icon: <ShoppingBagIcon /> },
  { title: "Favourites", icon: <FavoriteIcon /> },
  { title: "Address", icon: <HomeIcon /> },
  { title: "Payment", icon: <AccountBalanceWalletIcon /> },
  { title: "Notification", icon: <NotificationsActiveIcon /> },
  { title: "Events", icon: <EventIcon /> },
  { title: "Logout", icon: <LogoutIcon /> },
];

const ProfileNavigation = ({ open, handleClose }) => {
  const isSmallScreen = useMediaQuery('(max-width:900px)');

  const navigate = useNavigate();

  const handleNavigate = (item) =>{
    navigate(`/my-profile/${item.title.toLowerCase()}`)
  }

  const drawerContent = (
    <div className="w-[50vw] lg:w-[20vw] h-[90vh] flex flex-col justify-center text-xl gap-8  px-5 bg-black text-white">
      {menu.map((item, index) => (
        <React.Fragment key={index}>
          <div onClick={()=>handleNavigate(item)} className="flex items-center space-x-5 cursor-pointer hover:text-pink-500">
            {item.icon}
            <span>{item.title}</span>
          </div>
          {index !== menu.length - 1 && <Divider sx={{ borderColor: 'gray' }} />}
        </React.Fragment>
      ))}
    </div>
  );

  if (isSmallScreen) {
    return (
      <Drawer
        onClose={handleClose}
        variant="temporary"
        anchor="left"
        open={open}
        sx={{ zIndex: 1200 }}
      >
        {drawerContent}
      </Drawer>
    );
  }

  return drawerContent; // permanent drawer for large screens
};

export default ProfileNavigation;
