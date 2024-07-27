import { NavLink } from "react-router-dom";


function NavBar(){
    return (
        <div className="flex gap-52 justify-center items-center bg-blue-900 text-white h-[40px]">
            <NavLink to="/">All Files</NavLink>
            <NavLink to="/search">Get File</NavLink>
            <NavLink to="/upload">upload File</NavLink>
        </div>
    );
};

export default NavBar;