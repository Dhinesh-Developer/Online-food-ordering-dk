
import { Button, TextField, Typography } from '@mui/material'
import { Form, Formik,Field } from 'formik'
import React from 'react'
import { useDispatch } from 'react-redux'
import { useNavigate } from 'react-router-dom'
import { loginUser } from '../State/Authentication/Action'

const initialValues = {
  email: "",
  password: ""
}
const LoginForm = () => {
  const navigate = useNavigate()
  const dispatch = useDispatch()

  const handleSumbit=(values)=>{
    dispatch(loginUser({useDate:values,navigate}))
  }

  

  return (
    <div>
      <Typography variant='h5' className='text-center'>
        Login
      </Typography>
      <Formik onSubmit={handleSumbit} initialValues={initialValues}>
        <Form>
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
          />
          <Button sx={{mt:2,padding:"1rem"}} fullWidth type='submit' variant='contained'>
            Login
          </Button>
        </Form>
      </Formik>

      <Typography  variant='body2' align='center' sx={{mt:3}} >
        Don't have an account?
        <Button size='small'onClick={()=>navigate("/account/register")}>
          register
        </Button>
      </Typography>
    </div>
  )
}

export default LoginForm