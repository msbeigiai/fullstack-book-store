import { HStack } from "@chakra-ui/react";
import { Link } from "react-router-dom";
import ColorModeSwitch from "./ColorModeSwitch";
import SearchInput from "./SearchInput";

const NavBar = () => {
  return (
    <>
      <HStack padding="10px">
        <Link to="/">Library</Link>
        <SearchInput />
        <ColorModeSwitch />
        <Link to="/login">Login</Link>
      </HStack>
    </>
  );
};

export default NavBar;
