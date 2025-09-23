import { Button, Card } from '@mui/material'
import React from 'react'


const OrderCard = () => {
    return (
        <Card className='flex justify-center items-center p-5'>
            <div className='flex items-center space-x-5'>
                <img
                className='h-16 w-16'
                src="https://images.pexels.com/photos/1092730/pexels-photo-1092730.jpeg" alt="" />
                <div>
                    <p>Briyani</p>
                    <p>$399</p>
                </div>
            </div>
            <div className='pl-60'>
                <Button className='cursor-not-allowed'>Completed</Button>
            </div>
        </Card>
    )
}

export default OrderCard