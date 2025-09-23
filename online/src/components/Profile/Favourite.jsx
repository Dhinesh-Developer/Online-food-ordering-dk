import React from 'react'
import RestaurantCard from '../Restaurant/RestaurantCard'

const Favourite = () => {
  return (
    <div >
      <h1 className='py-5 text-xl font-semibold text-center'>My Favourites</h1>
      <div className='flex flex-wrap justify-center gap-5'>
        {[1,1,1,1].map((item)=><RestaurantCard/>)}
      </div>
    </div>
  )
}

export default Favourite