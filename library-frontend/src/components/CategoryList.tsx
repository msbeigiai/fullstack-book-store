import { Button, List, ListItem, Spinner, Text } from "@chakra-ui/react";
import useCategories from "../hooks/useCategories";


const CategoryList = () => {

  const { data, isLoading, error } = useCategories();

  if (isLoading) return <Spinner />

  if (error) return <Text>{error.message}</Text>

  return (
    <List>
      {data?.results.map((category) => (
        <ListItem key={category.name}>
          <Button
            whiteSpace="normal"
            textAlign="left"
            fontSize="lg"
            variant="link"
          >
            {category.name}
          </Button>
        </ListItem>
      ))}
    </List>
  );
};

export default CategoryList;
