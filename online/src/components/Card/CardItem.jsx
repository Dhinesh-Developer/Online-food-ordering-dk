import { Chip, IconButton } from '@mui/material'
import React from 'react'
import RemoveCircleOutlineIcon from '@mui/icons-material/RemoveCircleOutline';
import AddCircleOutlineIcon from '@mui/icons-material/AddCircleOutline';

const CardItem = () => {
  return (
    <div className='px-5'>
      <div className='lg:flex items-center lg:space-x-5'>
        <div>
          <img
            className='w-[5rem] h-[5rem] object-cover'
            src="https://images.pexels.com/photos/17649369/pexels-photo-17649369.jpeg"
            alt=""
          />
        </div>
        <div className='flex items-center justify-between lg:w-[70%]'>
          <div className='space-y-1 lg:space-y-3 w-full'>
            <p>Briyani</p>
            <div className='flex justify-between items-center'>
              <div className='flex items-center space-x-1'>
                <IconButton>
                  <RemoveCircleOutlineIcon />
                </IconButton>
                <span className='w-5 text-center'>1</span>
                <IconButton>
                  <AddCircleOutlineIcon />
                </IconButton>
              </div>
            </div>
          </div>
          <p>₹1956</p>
        </div>
      </div>
      <div className='pt-3 space-x-2'>
        {[1, 1, 1].map((item, idx) => (
          <Chip key={idx} label={"bread"} />
        ))}
      </div>
    </div>
  )
}

export default CardItem
