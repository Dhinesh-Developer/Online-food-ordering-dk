import React from 'react';
import {
  Divider,
  Card as MuiCard,
  Button,
  Modal,
  Box,
  Grid,
  TextField,
  Typography,
} from '@mui/material';
import AddLocationAltIcon from '@mui/icons-material/AddLocationAlt';
import CardItem from './CardItem';
import AddressCard from './AddressCard';
import { ErrorMessage, Field, Form, Formik } from 'formik';
import * as Yup from 'yup';

const items = [1, 1];

const style = {
  position: 'absolute',
  top: '50%',
  left: '50%',
  transform: 'translate(-50%, -50%)',
  width: 400,
  bgcolor: 'background.paper',
  outline: 'none',
  boxShadow: 24,
  p: 4,
};

const initialValues = {
  streetAddress: '',
  state: '',
  pincode: '',
  city: '',
};

const validationSchema = Yup.object().shape({
  streetAddress: Yup.string().required('Street address is required'),
  state: Yup.string().required('State is required'),
  pincode: Yup.string()
    .matches(/^\d{6}$/, 'Pincode must be 6 digits')
    .required('Pincode is required'),
  city: Yup.string().required('City is required'),
});

const Card = () => {
  const createOrderUsingSelectedAddress = (item) => {
    console.log('Selected Address:', item);
    // handle order logic
  };

  const [open, setOpen] = React.useState(false);
  const handleOpenAddressModel = () => setOpen(true);
  const handleClose = () => setOpen(false);

  const handleSubmit = (values) => {
    console.log('New Address:', values);
    setOpen(false);
  };

  return (
    <div>
      <main className="lg:flex justify-between">
        {/* Left Section */}
        <section className="lg:w-[30%] space-y-6 lg:min-h-screen pt-10">
          {items.map((item, index) => (
            <CardItem key={index} />
          ))}
          <Divider />
          <div className="billDetails px-5 text-sm">
            <p className="font-extralight py-5">Bill Details</p>
            <div className="space-y-3">
              <div className="flex justify-between text-gray-400">
                <p>Item Total</p>
                <p>₹599</p>
              </div>
              <div className="flex justify-between text-gray-400">
                <p>Delivery Fee</p>
                <p>₹21</p>
              </div>
              <div className="flex justify-between text-gray-400">
                <p>GST and Restaurant Charges</p>
                <p>₹33</p>
              </div>
              <Divider />
              <div className="flex justify-between text-gray-400 pt-3">
                <p>Total Pay</p>
                <p>₹3300</p>
              </div>
            </div>
          </div>
        </section>

        {/* Divider between sections */}
        <Divider orientation="vertical" flexItem />

        {/* Right Section */}
        <section className="lg:w-[70%] flex justify-center px-5 pb-10 lg:pb-0">
          <div>
            <h1 className="text-center font-semibold text-2xl py-10">
              Choose Delivery Address
            </h1>
            <div className="flex gap-5 flex-wrap justify-center">
              {[1, 1, 1, 1, 1].map((item, index) => (
                <AddressCard
                  key={index}
                  handleSelectAddress={createOrderUsingSelectedAddress}
                  item={item}
                  showButton={true}
                />
              ))}

              {/* Add new address card */}
              <MuiCard className="flex gap-5 w-64 p-5">
                <AddLocationAltIcon />
                <div className="space-y-3 text-gray-500">
                  <h1 className="font-semibold text-lg text-white">
                    Add New Address
                  </h1>
                  <Button
                    variant="outlined"
                    fullWidth
                    onClick={handleOpenAddressModel}
                  >
                    Add
                  </Button>
                </div>
              </MuiCard>
            </div>
          </div>
        </section>
      </main>

      {/* Address Modal */}
      <Modal
        open={open}
        onClose={handleClose}
        aria-labelledby="modal-modal-title"
      >
        <Box sx={style}>
          <Typography id="modal-modal-title" variant="h6" className="mb-4">
            Add New Address
          </Typography>

          <Formik
            initialValues={initialValues}
            validationSchema={validationSchema}
            onSubmit={handleSubmit}
          >
            {({ isSubmitting }) => (
              <Form>
                <Grid container spacing={2}>
                  <Grid item xs={12}>
                    <Field
                      as={TextField}
                      name="streetAddress"
                      label="Street Address"
                      fullWidth
                      variant="outlined"
                      helperText={<ErrorMessage name="streetAddress" />}
                      error={Boolean(<ErrorMessage name="streetAddress" />)}
                    />
                  </Grid>
                  <Grid item xs={6}>
                    <Field
                      as={TextField}
                      name="city"
                      label="City"
                      fullWidth
                      variant="outlined"
                      helperText={<ErrorMessage name="city" />}
                    />
                  </Grid>
                  <Grid item xs={6}>
                    <Field
                      as={TextField}
                      name="state"
                      label="State"
                      fullWidth
                      variant="outlined"
                      helperText={<ErrorMessage name="state" />}
                    />
                  </Grid>
                  <Grid item xs={12}>
                    <Field
                      as={TextField}
                      name="pincode"
                      label="Pincode"
                      fullWidth
                      variant="outlined"
                      helperText={<ErrorMessage name="pincode" />}
                    />
                  </Grid>
                  <Grid item xs={12}>
                    <Button
                      type="submit"
                      variant="contained"
                      fullWidth
                      disabled={isSubmitting}
                    >
                      Delivered
                    </Button>
                  </Grid>
                </Grid>
              </Form>
            )}
          </Formik>
        </Box>
      </Modal>
    </div>
  );
};

export default Card;
