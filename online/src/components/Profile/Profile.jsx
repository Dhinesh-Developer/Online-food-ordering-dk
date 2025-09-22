import React, { useState } from 'react';
import ProfileNavigation from './ProfileNavigation';
import { IconButton } from '@mui/material';
import MenuIcon from '@mui/icons-material/Menu';

const Profile = () => {
  const [openSideBar, setOpenSideBar] = useState(false);

  return (
    <div className="flex">
      {/* Sidebar */}
      <div className="lg:block hidden">
        <ProfileNavigation open={true} />
      </div>

      {/* Mobile Hamburger */}
      <div className="lg:hidden">
        <IconButton onClick={() => setOpenSideBar(true)}>
          <MenuIcon style={{ color: 'white' }} />
        </IconButton>
        <ProfileNavigation open={openSideBar} handleClose={() => setOpenSideBar(false)} />
      </div>

      {/* Main Content */}
      <div className="flex-1 ml-0 lg:ml-[20vw] p-5">
        <h1 className="text-2xl font-semibold text-white">Profile Page Content</h1>
        {/* Add your profile content here */}
      </div>
    </div>
  );
};

export default Profile;
