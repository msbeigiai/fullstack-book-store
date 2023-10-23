import React from "react";
import useBooks from "../hooks/useBooks";
import { Button, List, ListItem } from "@chakra-ui/react";

interface Props {
  onSelectCategory: (category: string) => void;
}

const categories = [
    {name: "FE", label: "Frontend"},
    {name: "BE", label: "Backend"},
    {name: "Data", label: "Data"},
    {name: "DevOps", label: "DevOps"},
];

const CategoryList = ({ onSelectCategory }: Props) => {
  const { data: books } = useBooks();

  return (
    <List>
      {categories.map((category) => (
        <ListItem key={category.name}>
          <Button
            whiteSpace="normal"
            textAlign="left"
            fontSize="lg"
            variant="link"
            onClick={() => onSelectCategory(category.label)}
          >
            {category.label}
          </Button>
        </ListItem>
      ))}
    </List>
  );
};

export default CategoryList;
