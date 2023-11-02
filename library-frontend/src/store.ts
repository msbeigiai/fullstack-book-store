import { create } from "zustand";

interface BookQuery {
  categoryId?: number | null;
  searchText?: string | null;
}

interface BookQueryStore {
  bookQuery: BookQuery;
  setCategoryId: (categoryId: number | null) => void;
  setSearchText: (searchText: string | null) => void;
}

const useBookQueryStore = create<BookQueryStore>((set) => ({
  bookQuery: {},
  setCategoryId: (categoryId) =>
    set((store) => ({ bookQuery: { ...store.bookQuery, categoryId } })),
  setSearchText: (searchText) =>
    set((store) => ({ bookQuery: { ...store.bookQuery, searchText } })),
}));

export default useBookQueryStore;
