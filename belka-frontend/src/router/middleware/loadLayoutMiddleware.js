export async function loadLayoutMiddleware(route) {
    const { layout } = route.meta
    console.log('**', layout)
    const layoutName = layout || 'MainLayout'

    const component = await import(`@/layouts/${layoutName}.vue`)
    route.meta.layoutComponent = component.default
}
