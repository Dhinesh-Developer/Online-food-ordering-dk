import React from "react";
import SearchIcon from "@mui/icons-material/Search";
import ShoppingCartIcon from "@mui/icons-material/ShoppingCart";
import { IconButton, Avatar, Badge } from "@mui/material";
import { pink } from "@mui/material/colors";
import "./Navbar.css";

const Navbar = () => {
  return (
    <div className="px-5 z-50 py-[.8rem] bg-[#f90673] lg:px-20 flex justify-between items-center">
      {/* Logo */}
      <div className="lg:mr-10 cursor-pointer flex items-center space-x-4">
        <span className="logo font-semibold text-gray-300 text-2xl font-serif">
          DK's FOOD
        </span>
      </div>

      {/* Right side: Search, Avatar, Cart */}
      <div className="w-50 flex justify-between items-center mr-30">
        {/* Search */}
        <IconButton>
          <SearchIcon sx={{ fontSize: "1.5rem" }} />
        </IconButton>

        {/* Avatar */}
        <Avatar sx={{ bgcolor: "white", color: pink.A400 }}>D</Avatar>

        {/* Cart */}
        <IconButton>
          <Badge color="primary" badgeContent={3}>
            <ShoppingCartIcon sx={{ fontSize: "1.5rem" }} />
          </Badge>
        </IconButton>
      </div>
    </div>
  );
};

export default Navbar;
