import axios from "axios";
import { API_URL } from "../../config/api";
import {
    LOGIN_REQUEST, LOGIN_SUCCESS, LOGIN_FAILURE,
    REGISTER_REQUEST, REGISTER_SUCCESS, REGISTER_FAILURE,
    GET_USER_REQUEST, GET_USER_SUCCESS, GET_USER_FAILURE,
    ADD_TO_FAVORITE_REQUEST, ADD_TO_FAVORITE_SUCCESS, ADD_TO_FAVORITE_FAILURE,
    LOGOUT
} from "./ActionType";

// REGISTER
export const registerUser = (reqData) => async (dispatch) => {
    dispatch({ type: REGISTER_REQUEST });
    try {
        const { data } = await axios.post(`${API_URL}/auth/signup`, reqData.userData);
        if (data.jwt) localStorage.setItem("jwt", data.jwt);
        dispatch({ type: REGISTER_SUCCESS, payload: data.jwt });
        reqData.navigate(data.role === "ROLE_RESTAURANT_OWNER" ? "/admin/restaurant" : "/");
    } catch (err) {
        dispatch({ type: REGISTER_FAILURE, payload: err });
        console.log("error", err);
    }
};

// LOGIN
export const loginUser = (reqData) => async (dispatch) => {
    dispatch({ type: LOGIN_REQUEST });
    try {
        const { data } = await axios.post(`${API_URL}/auth/signin`, reqData.userData);
        if (data.jwt) localStorage.setItem("jwt", data.jwt);
        dispatch({ type: LOGIN_SUCCESS, payload: data.jwt });
        reqData.navigate(data.role === "ROLE_RESTAURANT_OWNER" ? "/admin/restaurant" : "/");
    } catch (err) {
        dispatch({ type: LOGIN_FAILURE, payload: err });
        console.log("error", err);
    }
};

// GET USER
export const getUser = (jwt) => async (dispatch) => {
    dispatch({ type: GET_USER_REQUEST });
    try {
        const { data } = await axios.get(`${API_URL}/auth/me`, {
            headers: { Authorization: `Bearer ${jwt}` }
        });
        dispatch({ type: GET_USER_SUCCESS, payload: data.jwt });
        console.log("user profile", data);
    } catch (err) {
        dispatch({ type: GET_USER_FAILURE, payload: err });
        console.log("error", err);
    }
};

// ADD TO FAVORITE
export const addToFavorite = (jwt, restaurantId) => async (dispatch) => {
    dispatch({ type: ADD_TO_FAVORITE_REQUEST });
    try {
        const { data } = await axios.put(`${API_URL}/api/restaurant/${restaurantId}/add-favourite`, {}, {
            headers: { Authorization: `Bearer ${jwt}` }
        });
        dispatch({ type: ADD_TO_FAVORITE_SUCCESS, payload: data });
        console.log("add to favourite success", data);
    } catch (err) {
        dispatch({ type: ADD_TO_FAVORITE_FAILURE, payload: err });
        console.log("error", err);
    }
};

// LOGOUT
export const logout = () => (dispatch) => {
    localStorage.clear();
    dispatch({ type: LOGOUT });
    console.log("logout success");
};
