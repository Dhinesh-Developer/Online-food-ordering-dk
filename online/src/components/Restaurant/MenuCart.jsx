import React from 'react'
import Accordion from '@mui/material/Accordion';
import Typography from '@mui/material/Typography';
import AccordionSummary from '@mui/material/AccordionSummary';
import AccordionDetails from '@mui/material/AccordionDetails';
import ExpandMoreIcon from '@mui/icons-material/ExpandMore';
import { Category } from '@mui/icons-material';
import { Checkbox, FormControlLabel, FormGroup ,Button} from '@mui/material';

const demo = [
    {
        Category:"Nuts & seeds",
        ingredients:["Cashews"]
    },
    {
        Category:"Protein",
        ingredients:["Ground beef","Bacon strign"]
        
    },
    {
        Category:"Flavor",
        ingredients:["Wheat","maida"]
    },
    {
        Category:"Vegetable",
        ingredients:["carrot","cabbage","potato"]
    }

]

const MenuCart = () => {

    const handleCheckBoxChange = (value) => {
        console.log(value);
    }

  return (
    <div>
        <Accordion>
        <AccordionSummary
          expandIcon={<ExpandMoreIcon />}
          aria-controls="panel1-content"
          id="panel1-header"
        >
          <div className='lg:flex items-center justify-between'>
            <div className='lg:flex items-center lg:gap-5'>
                <img className='w-[7rem] h-[7rem] object-cover'
                 src="https://images.pexels.com/photos/2474658/pexels-photo-2474658.jpeg" alt="" />
                <div className='space-y-1 lg:space-y-5 lg:max-w-2xl'>
                    <p className='font-semibold text-xl'>Samosa</p>
                    <p>₹499</p>
                    <p className='text-gray-400'>The samosa is a popular Indian snack, loved for its crispy exterior and flavorful filling. Traditionally, it is a triangular pastry stuffed with a mixture of spiced potatoes, peas, onions, and sometimes lentils or minced meat.</p>
                </div>
            </div>
          </div>
        </AccordionSummary>
        <AccordionDetails>
          <form action="">
            <div className='flex gap-5 flex-wrap'>
                {
                    demo.map((item) => 
                        <div>
                            <p>{item.Category}</p>
                            <FormGroup>
                                {item.ingredients.map((item)=>  <FormControlLabel control={<Checkbox onChange={()=>{
                                    handleCheckBoxChange(item)
                                }} />} label={item} />)}
                                
                            </FormGroup>
                        </div>
                    
                )}
                
            </div>
            <div className='pt-5'>
                <Button type="submit" variant="contained"
                    disabled={false}
                >{true?"Add to Cart":"Out of Stock"}</Button>
            </div>
          </form>
        </AccordionDetails>
      </Accordion>

    </div>
  )
}

export default MenuCart