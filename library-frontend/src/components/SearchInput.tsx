import { useRef } from "react";
import useBookQueryStore from "../store";
import { BsSearch } from "react-icons/bs";
import { Input, InputGroup, InputLeftElement } from "@chakra-ui/react";

const SearchInput = () => {
  const ref = useRef<HTMLInputElement>(null);
  const setSearchText = useBookQueryStore((s) => s.setSearchText);

  return (
    <form
      onSubmit={(event) => {
        event.preventDefault();
        if (ref.current) {
          setSearchText(ref.current.value);
        }
      }}
    >
      <InputGroup>
        <InputLeftElement children={<BsSearch />} />
        <Input
          ref={ref}
          borderRadius={20}
          placeholder="Search books..."
          variant="filled"
        />
      </InputGroup>
    </form>
  );
};

export default SearchInput;
