import { Grid, GridItem, Show } from "@chakra-ui/react";
import BookList from "./components/BookList";
import CategoryList from "./components/CategoryList";
import NavBar from "./components/NavBar";
import { Book } from "./entities/Book";

export interface BookQuery {
  book: Book;
  categoryId: number;
}

function App() {
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
        <Show above="lg">
          <GridItem area="nav">
            <NavBar />
          </GridItem>
        </Show>
        <GridItem area="aside" paddingX={5}>
          <CategoryList />
        </GridItem>
        <GridItem area="main">
          <BookList />
        </GridItem>
      </Grid>
    </>
  );
}

export default App;
