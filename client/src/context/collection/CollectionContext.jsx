import { createContext, useContext } from 'react';

export const CollectionContext = createContext(null);

export function useCollection() {
  return useContext(CollectionContext);
}
