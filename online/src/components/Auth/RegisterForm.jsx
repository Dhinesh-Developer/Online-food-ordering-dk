
import { Button, TextField, Typography,FormControl,MenuItem,InputLabel, Select} from '@mui/material'
import { Form, Formik, Field } from 'formik'
import React from 'react'
import { useNavigate } from 'react-router-dom'
import { useDispatch } from 'react-redux'
import { loginUser, registerUser } from '../State/Authentication/Action'

const initialValues = {
  fullName: "",
  email: "",
  password: "",
  role: ""
}
const RegisterForm = () => {

  const navigate = useNavigate()
   const dispatch = useDispatch()


  const handleSumbit = (values) => {
    console.log(values)
     dispatch(registerUser({useDate:values,navigate}))
  }
  return (
    <div>
      <Typography variant='h5' className='text-center'>
        Register
      </Typography>
      <Formik onSubmit={handleSumbit} initialValues={initialValues}>
        <Form>
          <Field
            as={TextField}
            name="fullName"
            label="Full Name"
            fullWidth
            variant="outlined"
            margin="normal"
          />
          <Field
            as={TextField}
            name="email"
            label="Email"
            fullWidth
            variant="outlined"
            margin="normal"
          />
          <Field
            as={TextField}
            name="password"
            label="Password"
            fullWidth
            variant="outlined"
            margin="normal"
            type="password"
          />
        
          <FormControl fullWidth  margin="normal">
            <InputLabel id="role-simple-select-label">Role</InputLabel>
            <Field
            as={Select}
              labelId="role-simple-select-label"
              id="role-simple-select"
              name="role"
             // value={role}
              label="Role"
              // onChange={handleChange}
            >
              <MenuItem value={"ROLE_CUSTOMER"}>Customer</MenuItem>
              <MenuItem value={"ROLE_RESTAURANT_OWNER"}>Restaurant Owner</MenuItem>
            </Field>
          </FormControl>
          <Button sx={{ mt: 2, padding: "1rem" }} fullWidth type='submit' variant='contained'>
            Regiter
          </Button>
        </Form>
      </Formik>

      <Typography variant='body2' align='center' sx={{ mt: 3 }} >
        Already have an account?
        <Button size='small' onClick={() => navigate("/account/login")}>
          login
        </Button>
      </Typography>
    </div>
  )
}

export default RegisterForm