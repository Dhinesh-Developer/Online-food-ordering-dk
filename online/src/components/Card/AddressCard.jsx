import React from 'react'
import { Card as MuiCard, Button } from '@mui/material'
import HomeFilledIcon from '@mui/icons-material/HomeFilled';

const AddressCard = ({ item, showButton, handleSelectAddress }) => {
  return (
    <MuiCard className="flex gap-5 w-64 p-5">
      <HomeFilledIcon />
      <div className='space-y-3 text-gray-500'>
        <h1 className='font-semibold text-lg text-white'>Home</h1>
        <p>
          Mumbai, new shivam building, gokuldham market, 530068, Maharashtra, India
        </p>
        {showButton && (
          <Button
            variant='outlined'
            fullWidth
            onClick={() => handleSelectAddress(item)}
          >
            Select
          </Button>
        )}
      </div>
    </MuiCard>
  )
}

export default AddressCard
