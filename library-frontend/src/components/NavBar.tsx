import { HStack, Text } from "@chakra-ui/react";
import SearchInput from "./SearchInput";

const NavBar = () => {
  return (
    <>
      <HStack padding="10px">
        <Text>NavBar</Text>
        <SearchInput />
      </HStack>
    </>
  );
};

export default NavBar;
