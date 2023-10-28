import { Grid, GridItem } from "@chakra-ui/react";
import { useState } from "react";
import BookList from "./components/BookList";
import CategoryList from "./components/CategoryList";
import NavBar from "./components/NavBar";
import { Book } from "./entities/Book";

export interface BookQuery {
  book: Book;
  categoryId: number;
}

function App() {

  const [categoryId, setCategoryId] = useState(0)
  return (
    <>
      <Grid
        templateAreas={{
          base: `"nav" "main"`,
          lg: `"nav nav" "aside main"`,
        }}
        templateColumns={{
          base: "1fr",
          lg: "200px 1fr",
        }}
      >
        <GridItem area="nav">
          <NavBar />
        </GridItem>
        <GridItem area="aside" paddingX={5}>
          <CategoryList
            setSelectedCategoryId={(categoryId) => setCategoryId(categoryId)}
          />
        </GridItem>
        <GridItem area="main">
          <BookList categoryId={categoryId} />
        </GridItem>
      </Grid>
    </>
  );
}

export default App;
