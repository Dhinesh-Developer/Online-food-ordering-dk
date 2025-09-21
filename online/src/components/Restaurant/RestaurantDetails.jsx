import React, { useState } from 'react'
import { Divider, FormControl, FormControlLabel, Grid, Typography, RadioGroup, Radio } from '@mui/material'
import LocationOnTwoToneIcon from '@mui/icons-material/LocationOnTwoTone';
import CalendarTodayTwoToneIcon from '@mui/icons-material/CalendarTodayTwoTone';
import MenuCart from './MenuCart';

const category = ["pizza", "briyani", "burger", "chicken", "rice"];

const foodTypes = [
    { label: "All", value: "all" },
    { label: "Vegetarian", value: "vegetarian" },
    { label: "Non-Vegetarian", value: "non_vegetarian" },
    { label: "Seasonal", value: "seasonal" }
];

const menu = [1, 1, 1, 1, 1, 1];

const RestaurantDetails = () => {
    const [foodType, setFoodType] = useState("all");
    const [foodCategory, setFoodCategory] = useState("");

    const handleFoodTypeChange = (e) => setFoodType(e.target.value);
    const handleCategoryChange = (e) => setFoodCategory(e.target.value);

    return (
        <div className='px-5 lg:px-20 py-5'>
            {/* Breadcrumbs */}
            <section>
                <h3 className='text-gray-500 py-2 mt-10'>
                    Home / India / Indian Fast Food / 3
                </h3>

              <Grid container spacing={2}>
                {/* First Image - Full Width */}
                <Grid item xs={12}>
                    <img
                    className='w-full h-[40vh] object-cover rounded-lg'
                    src="https://images.pexels.com/photos/1058277/pexels-photo-1058277.jpeg"
                    alt="Restaurant Main"
                    />
                </Grid>

                {/* Second and Third Images - Side by Side on md+ screens, stacked on small screens */}
                <Grid item xs={12} md={6}>
                    <img
                    className='w-full h-[40vh] object-cover rounded-lg'
                    src="https://images.pexels.com/photos/262047/pexels-photo-262047.jpeg"
                    alt="Dish 1"
                    />
                </Grid>
                <Grid item xs={12} md={6}>
                    <img
                    className='w-full h-[40vh] object-cover rounded-lg'
                    src="https://images.pexels.com/photos/1307698/pexels-photo-1307698.jpeg"
                    alt="Dish 2"
                    />
                </Grid>
                </Grid>


                {/* Restaurant Info */}
                <div className='pt-5 pb-5'>
                    <h1 className='text-4xl font-semibold'>Indian Fast Food</h1>
                    <p className='text-gray-500 mt-1'>
                        Lorem ipsum dolor sit amet consectetur adipisicing elit. Hic, nam excepturi. Provident sunt quo hic iure officia assumenda eveniet fugiat suscipit, est unde mollitia ratione error expedita saepe, optio reiciendis nesciunt quia dolore ex qui soluta consequatur modi.
                    </p>
                    <div className='space-y-3 mt-3'>
                        <p className='text-gray-500 flex items-center gap-3'>
                            <LocationOnTwoToneIcon />
                            <span>Mumbai, Maharashtra</span>
                        </p>
                        <p className='text-gray-500 flex items-center gap-3'>
                            <CalendarTodayTwoToneIcon />
                            <span>Mon-Sun: 9:00 AM - 9:00 PM (Today)</span>
                        </p>
                    </div>
                </div>
            </section>

            <Divider />

            {/* Menu & Filters */}
            <section className='pt-8 lg:flex gap-10'>
                {/* Sidebar Filters */}
                <div className='lg:w-[20%] flex flex-col gap-6'>
                    {/* Food Type Filter */}
                    <div className='p-5 shadow-md rounded-md  top-28 z-10'>
                        <Typography variant='h6' className='pb-4'>Food Type</Typography>
                        <FormControl component="fieldset">
                            <RadioGroup value={foodType} onChange={handleFoodTypeChange}>
                                {foodTypes.map((item) => (
                                    <FormControlLabel
                                        key={item.value}
                                        value={item.value}
                                        control={<Radio />}
                                        label={item.label}
                                    />
                                ))}
                            </RadioGroup>
                        </FormControl>
                    </div>
                    <Divider/>
                    {/* Food Category Filter */}
                    <div className='p-5 shadow-md rounded-md  top-[18rem] z-10'>
                        <Typography variant='h6' className='pb-4'>Food Category</Typography>
                        <FormControl component="fieldset">
                            <RadioGroup value={foodCategory} onChange={handleCategoryChange}>
                                {category.map((item) => (
                                    <FormControlLabel
                                        key={item}
                                        value={item}
                                        control={<Radio />}
                                        label={item}
                                    />
                                ))}
                            </RadioGroup>
                        </FormControl>
                    </div>
                </div>

                {/* Menu Items */}
                <div className='lg:w-[80%] space-y-5'>
                    {menu.map((item, index) => (
                        <MenuCart key={index} />
                    ))}
                </div>
            </section>
        </div>
    )
}

export default RestaurantDetails;
